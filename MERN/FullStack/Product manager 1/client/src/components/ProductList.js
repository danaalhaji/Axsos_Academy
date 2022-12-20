import React from 'react';
import axios from 'axios';

const ProductList =(props) =>{
    return (
        <div style={{margin:"0 auto" , width:"40%"}}>
            {props.products.map((pro, idx) => {
                return <ul>
                <li key={idx}>
                    <ul>
                       <li> <span style={{fontWeight:"bold"}}>Title :</span>{pro.title} </li>
                       <li><span style={{fontWeight:"bold"}}>   Price:</span>{pro.price}$ </li>
                       <li><span style={{fontWeight:"bold"}}>   Description:</span> {pro.description} </li>
                        </ul>
                </li>
                </ul>
            })}
        </div>
    )
}
export default ProductList;