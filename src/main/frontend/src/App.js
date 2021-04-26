import React, {useState, useEffect} from 'react';
import './App.css';
import axios from 'axios';

const BookProfiles = () => {

  const [bookProfiles, setBookProfiles] = useState([]);

  const fetchBookProfiles = () => {
    axios.get('https://c868finalproject.herokuapp.com/api/v1/book').then(res => {
      console.log(res);
      setBookProfiles(res.data);
    });
  };

  useEffect(() => {
    fetchBookProfiles();
  }, []);

  return bookProfiles.map((bookProfile, index) => {
      return (
        <div key ={index}>
          <h1>{bookProfile.title}</h1>
          <p>{bookProfile.isbn}</p>
        </div>
      );
    });
};

function App() {
  return (
    <div className="App">
      <BookProfiles />
    </div>
  );
}

export default App;
