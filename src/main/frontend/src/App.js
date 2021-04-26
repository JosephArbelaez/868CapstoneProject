import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

const BookProfiles = () => {
  const fetchBookProfiles = () => {
    axios.get('https://c868finalproject.herokuapp.com/api/v1/book').then(res => {
      console.log(res);
    });
  }

  useEffect(() => {
    fetchBookProfiles();
  }, []);

  return <h1>hello</h1>
}

function App() {
  return (
    <div className="App">
      <BookProfiles />
    </div>
  );
}

export default App;
