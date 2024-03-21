import { Routes, Route, Navigate } from 'react-router-dom';
import { authHeader } from './helpers/auth-header';


function ProtectedRoute({ children, ...rest }) {
  if (authHeader()) {
    return children;
  }

  return <Navigate to="/login" replace />;
}

export default ProtectedRoute;
