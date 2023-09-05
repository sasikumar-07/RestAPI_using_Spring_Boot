
import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';
function Navbar() {
  return (
    <nav>
      <div className="nav-left">
        <Link to="/">PHARMACY MANAGEMENT</Link>
      </div>
      <div className="nav-right">
        <ul>
          <li>
            <Link to="/create">Add Medicine</Link>
          </li>
          <li>
            <Link to="/list">List Medicines</Link>
          </li>
          <li>
            <Link to="/update">Update Medicine</Link>
          </li>
          <li>
            <Link to="/delete">Delete Medicine</Link>
          </li>
          <li>
            <Link to="/search">Search Medicine</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;