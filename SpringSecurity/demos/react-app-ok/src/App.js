import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from './shared/Header';



function App() {
  return (
    <div className="App">  
    <header>
      <Header />
    </header>
    <main className="container mt-5">
          <Outlet />
    </main>
  </div>
  );
}

export default App;

