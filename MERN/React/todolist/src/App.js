import logo from './logo.svg';
import './App.css';
import TodoList from './component/TodoList';
import EditList from './component/EditList';
import { useState } from 'react';

function App() {
  const [toDo, setToDo] = useState([])
  const toDoList =(list)=>{
    setToDo([...toDo, list ])
  }
  return (
    <div className="App">
      <TodoList setList={toDoList}></TodoList>
      <EditList showList={toDo}></EditList>
    </div>
  );
}

export default App;
