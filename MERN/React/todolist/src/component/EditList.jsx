import React , { useState, useEffect } from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const EditList = (props) => {
    const [isChecked, setIsChecked] = useState();
    const [styleText , setStyleText] = useState("none")
    const [tasks, setTasks] = useState({})

    useEffect(()=>{
        setTasks(props.showList)},
        [props.showList]
    )
    const handleOnChange = (e) => {
      setIsChecked(!isChecked);
      if(e.target.checked){
        setStyleText("line-through")
      }
      else{
        setStyleText("none")
      }
    }
    const deleteItem =(t)=>{
        console.log(t)
        var array = [...tasks]
        array.splice(t,1);
        console.log(array)
        setTasks(array);
        console.log(tasks)
    }
  return (
    <div>
      {tasks.map((item , idx)=>{
            return (<div style={{width:"20%" , margin:"0 auto", display:"flex"}}key={idx} className="mb-3">
            <Form.Check onChange={(e) => handleOnChange(e)}
              type="checkBox"
            /><span style= {{textDecoration: styleText}} >{item.task}</span> <Button variant="danger" 
            type="submit" onClick={(e)=>deleteItem(idx)}> Delete</Button>
            </div>)
        })
      }
    </div>
  )
}

export default EditList
