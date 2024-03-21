import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from './shared/Navbar';



function App() {
  return (
    <div className="App">  
    <header>
      <Navbar />
    </header>
    <main className="container mt-5">
          <Outlet />
    </main>
  </div>
  );
}

export default App;

