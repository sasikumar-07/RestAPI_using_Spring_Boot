import React, { useState } from 'react';
import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';
import axios from 'axios';

function AddMedicine() {
  const [medicine, setMedicine] = useState({ medicinename: '', price: '', quantity: '' });
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/addmedicine', medicine);
      console.log(response.data);
      setSuccessMessage('Medicine added successfully.');
      setErrorMessage('');
      setMedicine({ medicinename: '', price: '', quantity: '' });
    } catch (error) {
      console.error('Error:', error);
      setSuccessMessage('');
      setErrorMessage('Failed to add medicine.');
    }
  };

  return (
    <div className='crud' >
      <h2>Add Medicine</h2>
      <br></br>
      {successMessage && <p className="success-message">{successMessage}</p>}
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Medicine Name"
          value={medicine.medicinename}
          onChange={(e) => setMedicine({ ...medicine, medicinename: e.target.value })}
        />
        <input
          type="text"
          placeholder="Price"
          value={medicine.price}
          onChange={(e) => setMedicine({ ...medicine, price: e.target.value })}
        />
        <input
          type="text"
          placeholder="Quantity"
          value={medicine.quantity}
          onChange={(e) => setMedicine({ ...medicine, quantity: e.target.value })}
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default AddMedicine;
