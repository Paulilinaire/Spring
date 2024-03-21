import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import Login from "./components/Login";
import Register from "./components/Register";

import ProtectedRoute from "./ProtectedRoute";
import TaskList from "./components/TaskList";
import CreateTask from "./components/CreateTask";


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
                path: "/tasks",
                element: <ProtectedRoute><TaskList /></ProtectedRoute>
            },
            {
                path: "/create-task",
                element: <ProtectedRoute><CreateTask /></ProtectedRoute>
            }

        ]
    }
])

export default router