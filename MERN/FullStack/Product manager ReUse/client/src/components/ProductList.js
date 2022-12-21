import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from '@reach/router';
import Button from '@mui/material/Button';
import DeleteButton from './DeleteButton';

const ProductList =(props) =>{
    const [product, setProduct] = useState([]);
   
    useEffect(() => {
        axios.get('http://localhost:8000/api/products')
            .then(res => setProduct(res.data));
    }, [])

    // const removeFromDom = proID => {
    // setProduct(product.filter(pro => pro._id != proID))
    // }

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
                        <DeleteButton proId={pro._id} successCallback={()=> props.removeFromDom(pro._id)}> </DeleteButton>
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