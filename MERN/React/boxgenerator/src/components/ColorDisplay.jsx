import React ,{ Component }  from 'react';


const ColorDisplay = (props) => {
  const removeNode = (idx) => document.getElementById(`id-${idx}`).remove();
  return (
    <div style={{display :"flex"}}>
      {props.newColorBox?.map((item ,idx)=>{
        return ( 
        <div style={ {width :"150px",
        height : "150px",
        padding: "5px",
        border: "1px solid red",
        margin :"0 auto",
        backgroundColor:item}} key={idx} id={`id-${idx}`} > <button onClick={() => removeNode(idx)}>x</button></div>);
      })}
      {/* <div style={{width:`${props.boxs.size}px` ,height:`${props.boxs.size}px`, backgroundColor:props.boxs.color}}>Hi</div> */}
      {/* {props.boxs?.map((item ,idx)=>{
        return (<div style={{
        width:`${item.size}px` ,height:`${item.size}px`,
        border: "1px solid red",
        margin :"0 auto",
        backgroundColor: item.color}}
        ></div>);
      })} */}
      </div>

  );
}

export default ColorDisplay
