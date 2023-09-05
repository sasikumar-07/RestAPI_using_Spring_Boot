import React from 'react';
import './styles.css';
import './Home.css';

const homePageStyle = {
  background: 'url(https://www.iimtindia.net/Blog/wp-content/uploads/2022/08/pharmaceutical-industry.jpg) no-repeat center center fixed',
  backgroundSize: 'cover',
  minHeight: '85vh',
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'center',
  color: '#fff',
};


function Home() {
  return (
    <div style={{...homePageStyle}}>
 
      <h1>Welcome to Your Pharmacy</h1>
      <p>Medicines cure diseases, but only doctors can cure patients</p>
    </div>
  
  );
}

export default Home;
