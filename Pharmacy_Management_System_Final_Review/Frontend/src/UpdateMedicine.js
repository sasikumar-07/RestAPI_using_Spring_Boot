
import React, { useState } from 'react';
import './styles.css';
import './crudStyles.css'; // Import the CSS file for styling

import axios from 'axios';

function UpdateMedicine() {
  const [id, setId] = useState('');
  const [formValues, setFormValues] = useState({
    medicinename: '',
    price: '',
    quantity: '',
  });
  const [updateMessage, setUpdateMessage] = useState('');

  const handleIdChange = (e) => {
    setId(e.target.value);
  };

  const handleMedicineChange = (e) => {
    const { name, value } = e.target;
    setFormValues({
      ...formValues,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const updatedMedicine = {
       medicineid : id,
        ...formValues, // Include all form values in the update
      };

      const response = await axios.put(`http://localhost:8080/updatebyid/${id}`, updatedMedicine);
      if (response.status === 200) {
        // Medicine updated successfully, update the message
        setUpdateMessage('Medicine updated successfully.');
      } else {
        // Handle the error case
        setUpdateMessage('Error: Failed to update medicine.');
      }
    } catch (error) {
      console.error('Error:', error);
      setUpdateMessage('Error: Failed to update medicine. Please check your network connection.');
    }
  };

  return (
    <div className='crud'>
      <h2>Update Medicine</h2>
      <br></br>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Medicine ID"
          value={id}
          onChange={handleIdChange}
        />
        <br></br>
        <br></br>
        <input
          type="text"
          name="medicinename"
          placeholder="Medicine Name"
          value={formValues.medicinename}
          onChange={handleMedicineChange}
        />
        <input
          type="text"
          name="price"
          placeholder="Price"
          value={formValues.price}
          onChange={handleMedicineChange}
        />
        <input
          type="text"
          name="quantity"
          placeholder="Quantity"
          value={formValues.quantity}
          onChange={handleMedicineChange}
        />
        <button type="submit">Update</button>
      </form>
      <p>{updateMessage}</p>
    </div>
  );
}

export default UpdateMedicine;


