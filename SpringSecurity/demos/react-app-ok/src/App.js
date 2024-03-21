import React from 'react';
import { BrowserRouter as Router, Route, Routes, Outlet } from 'react-router-dom';
import Header from './shared/Header';




function App() {
  return (
    <div className="App">
    <header>
      <Header />
    </header>
    <main className="container mt-5">
      <div class="row justify-content-md-center">
        <div class="col-8">
          <Outlet />
          </div>
      </div>
    </main>
  </div>
  );
}

export default App;

