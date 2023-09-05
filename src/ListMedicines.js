
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';

function ListMedicines() {
  const [medicines, setMedicines] = useState([]);

  useEffect(() => {
    const fetchMedicines = async () => {
      try {
        const response = await axios.get('http://localhost:8080/medicineDetails');
        if (response.status === 200) {
          // Axios automatically parses JSON response data
          setMedicines(response.data); // Use response.data to access the parsed JSON
        } else {
          // Handle the error case
          console.error('Error:', response.statusText);
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };
    fetchMedicines();
  }, []);

  return (
    <div className='crud'>
      <div></div>
      <h2>Medicine List</h2>
      <br></br>
      <ul>
        {medicines.map((medicine) => (
          <li key={medicine.id}>
            <h3>MEDICINEID:{medicine.medicineid}</h3>
            <h3>  MEDICINENAME: {medicine.medicinename} </h3>
            <h3>PRICE:  {medicine.price} </h3>
           <h3> QUANTITY:    {medicine.quantity} </h3>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListMedicines;

