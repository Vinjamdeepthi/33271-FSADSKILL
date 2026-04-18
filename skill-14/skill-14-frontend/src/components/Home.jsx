import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

export default function Home() 
{
  const navigate = useNavigate();

  useEffect(() => {
    if (!localStorage.getItem("user")) navigate("/");
  }, []);

  return <h2>Welcome Home</h2>;
}