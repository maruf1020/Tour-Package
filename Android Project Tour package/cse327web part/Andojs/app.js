const express = require('express')
const app = express()

app.use(express.json())

app.listen(3000, ()=>{
    console.log("Listeming on port 30000...")
})