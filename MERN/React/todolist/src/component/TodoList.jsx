import React, { useState } from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const TodoList = (props) => {
    const [newTask, setNewTask] = useState("");
    console.log(newTask);

    const addTaskToList =(e)=>{
        e.preventDefault();
        props.setList(newTask);
        setNewTask("")
    }
  return (
    <div style={{width:"50%" , margin:"0 auto"}}>
      <Form onSubmit={(e) => addTaskToList(e)}>
      <Form.Label className="text-success">New Task</Form.Label>
        <Form.Control type="text" className="text-success" placeholder="Enter Your New Task...."
        value={newTask}
          onChange={(e) => setNewTask(e.target.value)}/>
        <Form.Text className="text-success">
          Make Sure To Finish And Delete, Stay Motivated!
        </Form.Text>
        <Button variant="warning" type="submit"  >
        Submit
      </Button>
      </Form>

    </div>
  )
}

export default TodoList
