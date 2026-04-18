import { Link, useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();

  return (
    <nav>
      <Link to="/home">Home</Link>
      <Link to="/profile">Profile</Link>
      <button onClick={() => {
        localStorage.clear();
        navigate("/");
      }}>Logout</button>
    </nav>
  );
}