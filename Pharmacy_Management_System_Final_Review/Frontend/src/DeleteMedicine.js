
import React, { useState } from 'react';
import axios from 'axios';
import './crudStyles.css'; // Import the CSS file for styling
import './styles.css';




function DeleteMedicine() {
  const [id, setId] = useState('');
  const [deleteMessage, setDeleteMessage] = useState('');

  const handleIdChange = (e) => {
    setId(e.target.value);
  };

  const handleDelete = async () => {
    try {
      const response = await axios.delete(`http://localhost:8080/delid/${id}`);
      if (response.status === 200) {
        // Medicine deleted successfully, update the message
        setDeleteMessage('Medicine deleted successfully.');
      } else {
        // Handle the error case
        setDeleteMessage('Error: Failed to delete medicine.');
      }
    } catch (error) {
      console.error('Error:', error);
      setDeleteMessage('Error: Failed to delete medicine. Please check your network connection.');
    }
  };
return (
    <div className='crud'>
      <h2>Delete Medicine by ID</h2>
      <input
        type="text"
        placeholder="Medicine ID"
        value={id}
        onChange={handleIdChange}
      />
      <button onClick={handleDelete}>Delete</button>
      <p>{deleteMessage}</p>
    </div>
  );
}
export default DeleteMedicine;


