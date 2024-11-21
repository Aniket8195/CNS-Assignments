const express=require('express');
const bcrypt=require('bcrypt');
const cors=require('cors');
const app=express();
const port=3000;

app.use(cors());
app.use(express.json());

app.listen(3000,()=>{
    console.log(`Server is running on port ${port}`);
});

app.post('/login',async (req,res)=>{
    const email=req.body.email;
    const password=req.body.password;
    console.log(email);
    console.log(password);
      
   const hashedPassword= await bcrypt.hash(password,10);
    console.log(hashedPassword);
    res.json('Login Successful');
});