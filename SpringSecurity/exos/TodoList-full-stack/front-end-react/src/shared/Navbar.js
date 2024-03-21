import { useNavigate, Link } from "react-router-dom";
import { getUserDetails } from "../helpers/user-details";
import authService from '../services/authService';
// import logo from './logo.png'


const Navbar = () => {
  const navigate = useNavigate();
  const userDetails = getUserDetails();
  
  
  const extractBeforeAt = (email) => {
    const atIndex = email.indexOf("@");

    return atIndex !== -1 ? email.substring(0, atIndex) : email;
};

  const isAdmin = () => {
      return userDetails && userDetails.role === 'ROLE_ADMIN';
  };

const isLoggedIn = () => {
  console.log(userDetails);

  const user = localStorage.getItem('user');
  return !!user;
};


  const handleLogout = () => {
      authService.logout();
      navigate('/login'); 
  };

  
    return ( 
        <div className="bg-gradient-to-r from-rose-600 via-pink-500 to-yellow-500 px-6 py-4 shadow">
          <div className="flex flex-col container mx-auto md:flex-row md:items-center md:justify-between">
            <div className="flex justify-between items-center">
                {/* <img className="size-24" src={logo} alt="Logo" /> */}
                <Link className="text-white text-xl font-bold md:text-2xl" to={"/"}> TodoList</Link>
            </div>
            {isAdmin() && (
                <Link className="nav-link" to={"/create-product"}>Add task</Link>
                  )}
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
            {!isLoggedIn() ? (
                        <>
                            <li className="nav-item mr-4" style={{ listStyleType: 'none' }}>
                                <button className="btn btn-outline-success me-2" onClick={() => navigate('/login')}>Connexion</button>
                            </li>
                            <li className="nav-item" style={{ listStyleType: 'none' }}>
                                <button className="btn btn-outline-primary" onClick={() => navigate('/register')}>Créer un compte</button>
                            </li>
                        </>
                    ) : (
                        <li className="nav-item" style={{ listStyleType: 'none' }}>
                             <span className="navbar-text mr-4">
                             Hello, {extractBeforeAt(userDetails.name)}
                            </span> 
                            <button className="btn btn-outline-danger" onClick={handleLogout}>Deconnexion</button>
                        </li>
                    )}
            </div>
          </div>
        </div>
     );
}
 
export default Navbar;