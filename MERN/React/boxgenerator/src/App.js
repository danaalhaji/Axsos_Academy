import logo from './logo.svg';
import './App.css';
import ColorForm from './components/ColorForm';
import ColorDisplay from './components/ColorDisplay';
import { useState } from 'react';

function App() {
  const initialState =[
    {color : "" , size :"", }
  ]
  const [boxColors, setBoxColor] = useState("");
  const [boxNewSize, setBoxSize] = useState("");
  const [colorArray , setColorArray] = useState([]);
  const [box , setBox] = useState(initialState)
  const boxColor =(newColor)=>{
    setBoxColor(newColor);
    setColorArray([...colorArray , boxColors]);
  }
  const newBox = (newColor, newSize) =>{
    setBox([...box,[{color:newColor, size: newSize}]]);
  }
console.log(box)
  // console.log(boxColors)
  // console.log(colorArray);
  return (
    <div className="App">
      <ColorForm  onBoxColor={boxColor} boxWithSize ={newBox}></ColorForm>
      <hr></hr>
      <ColorDisplay newColorBox={ colorArray } boxs={box}></ColorDisplay>
    </div>
  );
}

export default App;
