import React, { useEffect, useState } from 'react'


import AspectRatio from '@mui/joy/AspectRatio';
import Card from '@mui/joy/Card';
import CardOverflow from '@mui/joy/CardOverflow';
import Divider from '@mui/joy/Divider';
import Typography from '@mui/joy/Typography';
import IconButton from '@mui/joy/IconButton';
import { pink } from '@mui/material/colors';
import Favorite from '@mui/icons-material/Favorite';
import { Link } from '@reach/router';


import axios from 'axios';
import { height } from '@mui/system';


export default function Details(props) {
    const[author, setAuthor] = useState({});
    const[loaded , setLoaded] = useState(false)
    let image =["https://i.pinimg.com/736x/c2/45/1f/c2451fe7e38b08ab760c9724e89e91ad.jpg" , 
     "https://play-lh.googleusercontent.com/IdUb7Szz7X_fDaAKWkBh1vK5HB1fJrCvmfmDjUBWZPlP35XdLHNiq_dstX_AsQ-sAB0=w240-h480-rw",
    "https://preview.redd.it/g7edtnf5slh81.png?width=640&crop=smart&auto=webp&s=7ef3633e371ac744ba6b347db5bf88e0b851eb7e",
"https://img.freepik.com/premium-vector/turtle-mascot-illustration-with-premium-quality-stock-vector_136066-515.jpg?w=2000",
"https://i.pinimg.com/originals/19/18/f5/1918f50cc082e96b9a4fa21577ce08a1.jpg",
"https://i.pinimg.com/originals/5a/a9/3d/5aa93dad1a9f0360a1551270fe989646.jpg",
"https://f.i.uol.com.br/fotografia/2013/08/02/305565-400x600-1.jpeg"]

    useEffect(() =>{
        axios.get('http://localhost:8000/api/auther/' + props.id)
        .then(res => {setAuthor(res.data); setLoaded(true);})
        .catch(err => console.error(err));
         
    },[]);
    let i= image[Math.floor(Math.random() * 7) ];
    console.log(i)

  return (

    <Card variant="outlined" sx={{ width: 320 , margin:"0 auto" , marginTop:"5%"}}>
      <CardOverflow >
        <AspectRatio ratio="1">
          <img
            src= {i}
            srcSet={i}
            loading="lazy"
            alt=""
          />
        </AspectRatio>
        <IconButton
          aria-label="Like minimal photography"
          size="md"
          variant="solid"
          color="danger"
          sx={{
            position: 'absolute',
            zIndex: 2,
            borderRadius: '50%',
            right: '1rem',
            bottom: 0,
            transform: 'translateY(50%)',
          }}
        >
          <Favorite />
        </IconButton>
      </CardOverflow>
      <Typography level="h1" sx={{ fontSize: 'xl4', mt: 5 }} style={{color : pink[900]}}>
          {loaded && author.auther.name}
      </Typography>
      <Typography level="body2" sx={{ mt: 0.5, mb: 2 }}>
        <Link to="/">Back Home</Link>
      </Typography>
      <Divider inset="context" />
    </Card>
  );
}