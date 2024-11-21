document.getElementById("form-container").addEventListener("submit",async (e)=>{
    e.preventDefault();

    const email=document.getElementById("Email").value;
    const password=document.getElementById("password").value;

    const res= await fetch("http://localhost:3000/login",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(
            {
                email:email,
                password:password
            }
        )
    });
    const data=await res.json();
    console.log(data);
});