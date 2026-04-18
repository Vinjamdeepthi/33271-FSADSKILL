import { useEffect, useState } from "react";
import API from "../api";

export default function Profile() {
  const [user, setUser] = useState({});

  useEffect(() => {
    const stored = JSON.parse(localStorage.getItem("user"));
    API.get(`/user/${stored.id}`).then(res => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>{user.username}</p>
    </div>
  );
}