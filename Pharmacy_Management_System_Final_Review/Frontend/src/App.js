import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AddMedicine from './AddMedicine';
import ListMedicines from './ListMedicines';
import UpdateMedicine from './UpdateMedicine';
import DeleteMedicine from './DeleteMedicine';
import Search from './Search';
import Navbar from './Navbar';
import Home from './Home';
import Footer from './Footer';
import './styles.css';

function App() {
  return (
    <BrowserRouter>
      <div className="center-content">
        <Navbar />
        <Routes id='crud'>
          <Route path="/" element={<Home />} />
          <Route path="/create" element={<div className="operation-container"><AddMedicine /></div>} />
          <Route path="/list" element={<div className="operation-container"><ListMedicines /></div>} />
          <Route path="/update" element={<div className="operation-container"><UpdateMedicine /></div>} />
          <Route path="/delete" element={<div className="operation-container"><DeleteMedicine /></div>} />
          <Route path="/search" element={<div className="operation-container"><Search/></div>} />
        </Routes>
        <Footer/>
      </div>
    </BrowserRouter>
  );
}

export default App;