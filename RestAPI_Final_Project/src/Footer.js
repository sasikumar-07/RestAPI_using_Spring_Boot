

import React from 'react';
import { FaFacebook, FaTwitter, FaInstagram, FaGithub } from 'react-icons/fa';

function Footer() {
  return (
    <footer className="footer">
      <div className="social-icons">
        <a href="https://www.github.com" target="_blank" rel="noopener noreferrer">
          <FaGithub />
        </a>
        <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer">
          <FaTwitter />
        </a>
        <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
          <FaInstagram />
        </a>
        <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">
          <FaFacebook />
        </a>
      </div>
    </footer>
  );
}

export default Footer;

