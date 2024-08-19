const express = require('express');
const path = require('path');
const { title } = require('process');

const app = express();

app.use(express.json());
app.use(express.urlencoded({extended:false}));
// app.use(express.static('src'));

app.get('/',(req,res)=>{
    res.send("This is CSC3103");
});

// app.get('/',(req,res)=>{
//     res.json({name:"abcd"});
// });

// app.get('/',(req,res)=>{
//     res.send(req.header('host'));
// });

// app.get('/',(req,res)=>{
//     res.send(req.header('user-agent'));
// });

// app.get('/',(req,res)=>{
//     res.send(req.rawHeaders);
// });

// app.post('/contact', (req,res)=> {
//     res.send(req.header('Content-Type'));
// });

// app.post('/contact', (req,res)=> {
//     res.send(req.header('Content-Type'));
// });

app.post('/contact', (req,res)=> {
    if(!req.body.name){
        return res.status(400).send('Name is required');
    }

    //Database operation
    res.status(200).send(`Thank you ${req.body.name}`);

});

app.post('/login',(req,res)=> {
    if(!req.header('x-auth-token')){
        return res.status(400).send('No Token Available');
    }

    if(req.header('x-auth-token')!='123456'){
        return res.status(401).send('Unauthorized Login');
    }

    res.send("Succefully Logged In");
});

app.put('/post/:id',(req,res)=> {
    //you can do database operations whatever you want here

    res.json({
        id:req.params.id,
        title:req.body.title
    });
});

app.delete('/post/:id',(req,res)=>{
    res.json({msg:`Post ${req.params.id} successfully deleted`});
});

app.listen(5001,() => console.log('Server started on port: 5001'));