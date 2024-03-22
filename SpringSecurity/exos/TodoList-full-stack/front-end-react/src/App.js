import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from './shared/Navbar';
// import Footer from './shared/Footer';



function App() {
  return (
    <div className="App">  
    <header>
      <Navbar />
    </header>
    <main className="container">
          <Outlet />
    </main>
    {/* <footer>
      <Footer/>
    </footer> */}
  </div>
  );
}

export default App;

