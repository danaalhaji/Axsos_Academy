import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const ColorForm = (props) => {
    const [color, setColor] = useState("");
    const [size, setSize] = useState("")
    const handleSubmit =(e)=>{
        e.preventDefault();
        props.onBoxColor( color );
        props.boxWithSize( color , size);
        setColor("");
    }

    return (
    <div style={{width:"50%", margin:"0 auto"}}>
        <h1>Welcome to boxes generator</h1>
        <Form onSubmit={ handleSubmit }>
            <Form.Group className="mb-3" >
            <Form.Label>New Box Color
            </Form.Label>
            <Form.Control type="text" placeholder="Enter Color" onChange={(e)=> setColor(e.target.value)} value={color}/>
            <Form.Text className="text-muted">
                Enter the color for the new genratd box 
            </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" >
            <Form.Label>New Box size
            </Form.Label>
            <Form.Control type="text" placeholder="Enter Size" onChange={(e)=> setSize(e.target.value)} />
            <Form.Text className="text-muted">
                Enter the size for the new genratd box 
            </Form.Text>
            </Form.Group>
            <Button variant="success" type="submit">
                Generate
            </Button>
        </Form>
    </div>
    )
}

export default ColorForm
