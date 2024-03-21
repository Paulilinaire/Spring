import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ProductList from "./components/ProductList"
import Login from "./components/Login";
import Register from "./components/Register";
import CreateProduct from "./components/CreateProduct";
import ProtectedRoute from "./ProtectedRoute";


const router = createBrowserRouter([
    {
        path :"/",
        element : <App />,
        children: [
            {
                path: "/login",
                element: <Login />
            },
            {
                path: "/register",
                element: <Register />
            },
            {
                path: "/products",
                element: <ProtectedRoute><ProductList /></ProtectedRoute>
            },
            {
                path: "/create-product",
                element: <ProtectedRoute><CreateProduct /></ProtectedRoute>
            },
            {
                path: "/edit-product/:id",
                element: <ProtectedRoute><CreateProduct /></ProtectedRoute>
            }

        ]
    }
])

export default router