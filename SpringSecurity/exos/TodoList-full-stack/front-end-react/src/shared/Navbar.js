import { useNavigate, Link } from "react-router-dom";
import { getUserDetails } from "../helpers/user-details";
import authService from '../services/authService';

const Navbar = () => {
  const navigate = useNavigate();
  const userDetails = getUserDetails();

  const isAdmin = () => {
    return userDetails && userDetails.role === 'ROLE_ADMIN';
  };

  const isLoggedIn = () => {
    return !!userDetails;
  };

  const handleLogout = () => {
    authService.logout();
    navigate('/login'); 
  };

  return ( 
    <div className="bg-gradient-to-r from-rose-600 via-pink-500 to-yellow-500 px-6 py-4 shadow">
      <div className="container mx-auto flex flex-col md:flex-row items-center justify-between">
        <div className="flex items-center">
          {/* <img className="size-24" src={logo} alt="Logo" /> */}
          <Link className="text-white text-xl font-bold md:text-2xl" to={"/"} style={{ textDecoration: 'none' }}> TodoList</Link>
        </div>
        {isAdmin() && (
          <Link className="nav-link" to={"/create-product"}>Add task</Link>
        )}
        <div className="flex items-center">
          {!isLoggedIn() ? (
            <>
              <button className="personIcon my-1 text-gray-100 hover:text-pink-600 md:mx-4 md:my-0 me-5 2 mb-2" onClick={() => navigate('/login')}><i className="bi bi-person-fill"></i></button>
              <button className="text-white bg-gradient-to-r from-white-400 via-pink-500 to-pink-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-pink-300 dark:focus:ring-pink-800 shadow-lg shadow-pink-500/50 dark:shadow-lg dark:shadow-pink-800/80 font-medium rounded-lg text-sm px-4 py-2.5 text-center me-2 mb-2" onClick={() => navigate('/register')}>Subscribe</button>
            </>
          ) : (
            <div className="flex items-center">
              <span className="text-white mr-4">Hello, {(userDetails.name)}</span> 
              <button className="btn btn-outline-danger" onClick={handleLogout}>Deconnexion</button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default Navbar;
