import logo from './logo.svg';
import './App.css';
import io from 'socket.io-client';
import React, { useState, useEffect } from 'react';
import Chat from './component/Chat';
function App() {

  return (
    <div className="App">
      <h1>Chat Test</h1>
      <Chat></Chat>
    </div>
  );
}

export default App;
