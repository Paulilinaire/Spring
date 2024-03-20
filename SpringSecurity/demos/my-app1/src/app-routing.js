import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ProductList from "./components/ProductList"
import Login from "./components/Login";
import Register from "./components/Register";



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
                element: <ProductList />
            },

        ]
    }
])

export default router