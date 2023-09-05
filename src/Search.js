import React, { useState } from 'react';

function Search() {
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);

  const handleSearch = async () => {
    try {
      // Perform a search using the searchQuery, e.g., by sending a request to your API
      // Replace the URL with the actual endpoint for searching medicines
      const response = await fetch(`http://localhost:8080/cn/${searchQuery}`);
      if (response.status === 200) {
        const data = await response.json();
        setSearchResults(data);
      } else {
        console.error('Error:', response.statusText);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className='crud'>
      <h2>Search Medicines</h2>
      <br></br>
      <input
        type="text"
        placeholder="Enter medicine name"
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
      />
      <button onClick={handleSearch}>Search</button>

      {searchResults.length > 0 && (
        <div>
          <h2>Search Results</h2>
          <br></br>
          <ul>
            {searchResults.map((medicine) => (
              <li key={medicine.id}>
                 <h3>MEDICINEID:{medicine.medicineid}</h3>
            <h3>  MEDICINENAME: {medicine.medicinename} </h3>
            <h3>PRICE:  {medicine.price} </h3>
           <h3> QUANTITY:    {medicine.quantity} </h3>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default Search;
