import { useState } from "react";
import API from "../api";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [form, setForm] = useState({});
  const navigate = useNavigate();

  const login = async (e) => {
    e.preventDefault();
    const res = await API.post("/login", form);
    localStorage.setItem("user", JSON.stringify(res.data));
    navigate("/home");
  };

  return (
    <form onSubmit={login}>
      <h2>Login</h2>
      <input placeholder="Username" onChange={e => setForm({...form, username:e.target.value})}/>
      <input type="password" placeholder="Password" onChange={e => setForm({...form, password:e.target.value})}/>
      <button>Login</button>
    </form>
  );
}