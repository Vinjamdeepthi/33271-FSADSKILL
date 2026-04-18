import { useState } from "react";
import API from "../api";
import { useNavigate } from "react-router-dom";

export default function Register() 
{
  const [form, setForm] = useState({});
  const navigate = useNavigate();

  const register = async (e) => {
    e.preventDefault();
    await API.post("/register", form);
    navigate("/");
  };

  return (
    <form onSubmit={register}>
      <h2>Register</h2>
      <input placeholder="Username" onChange={e => setForm({...form, username:e.target.value})}/>
      <input type="password" placeholder="Password" onChange={e => setForm({...form, password:e.target.value})}/>
      <button>Register</button>
    </form>
  );
}