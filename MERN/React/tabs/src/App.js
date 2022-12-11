import logo from './logo.svg';
import './App.css';
import TabsForm from './component/TabsForm';
import { useState } from 'react';
import TabsDisplay from './component/TabsDisplay';

function App() {
  const [newTab , setNewTab] = useState("");
  const changeTab= (tab)=>{
    setNewTab(tab)
  }
  return (
    <div className="App">
      <TabsForm changeTab ={changeTab}></TabsForm>
      <TabsDisplay newChange ={newTab}></TabsDisplay>
    </div>
  );
}

export default App;
