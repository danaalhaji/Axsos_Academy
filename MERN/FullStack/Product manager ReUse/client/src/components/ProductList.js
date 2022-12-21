import React from 'react';
import axios from 'axios';
import { Link } from '@reach/router';
import Button from '@mui/material/Button';

const ProductList =(props) =>{
    const deletePoduct = (proId) => {
        axios.delete(`http://localhost:8000/api/products/${proId}`)
            .then(res => {
                props.removeFromDom(proId)
            })
            .catch(err => console.error(err));
    }

    return (
        <div style={{margin:"0 auto" , width:"40%"}}>
            {props.products.map((pro, idx) => {
                return <ul>
                <li key={idx}>
                    <ul key={idx}>
                    <Link to={"/" + pro._id}>
                        #{idx+1}
                    </Link>
                        <li> <span style={{fontWeight:"bold"}}>
                            Title :</span>{pro.title} </li>
                        <li><span style={{fontWeight:"bold"}}> 
                            Price:</span>{pro.price}$ </li>
                        <li><span style={{fontWeight:"bold"}}>
                            Description:</span> {pro.description} </li>
                        <Button variant="outlined" color="error"
                        onClick={(e)=>{deletePoduct(pro._id)}}
                        >Delete Item</Button>
                        <span>    </span>
                    <Link to={"/update/" + pro._id}>
                    <Button variant="outlined" color="success">
                        Update Item</Button>
                    </Link>
                    </ul>
                </li>
                </ul>
            })}
        </div>
    )
}
export default ProductList;