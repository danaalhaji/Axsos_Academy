import logo from './logo.svg';
import './App.css';
import TodoList from './component/TodoList';
import EditList from './component/EditList';

import 'bootstrap/dist/css/bootstrap.min.css';
import Stack from 'react-bootstrap/Stack';
import Button from 'react-bootstrap/Button';

import { useState } from 'react';

function App() {
  const [toDo, setToDo] = useState([])
  const toDoList =(list)=>{
    setToDo([...toDo, list ])
  }
  const deleteTasks =()=>{
    setToDo([]);
  }
  return (
    <div className="App">
       <Stack gap={3} style={{padding:"50px"}}>
        <TodoList setList={toDoList}></TodoList>
        <Button variant="outline-info" type="submit" style={{width:"20%" , margin:"0 auto"}}
        onClick={deleteTasks}>
        Start new tasks
      </Button>
      <span className="text-info">
          This will delelte all tasks and start new List
        </span>
        <hr></hr>
        <EditList showList={toDo}></EditList>
      </Stack>
    </div>
  );
}

export default App;
