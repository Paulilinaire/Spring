import api from './api';
import { authHeader } from '../helpers/auth-header';
import { getUserDetails } from '../helpers/user-details';

const getAllTasks = () => {
  return api.get('/tasks/user');
};

const getAllTasksByUserId = (id) => {
  return api.get(`/tasks/admin/${id}/todos`, { headers: authHeader() });
};

const addTask = (name, price) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can add tasks.");
    }

    return api.post('/tasks/admin', { name, price }, { headers: authHeader() });
  }

const deleteTask = (id) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can delete tasks.");
    }

    return api.delete(`/admin/${id}`, { headers: authHeader() });
  }

const updateTask = (id) => {
    const userDetails = getUserDetails();
    const isAdmin = userDetails && userDetails.role === 'ROLE_ADMIN';

    if (!isAdmin) {
      console.error("Only admins can delete tasks.");
    }

    return api.put(`/tasks/${id}`, { headers: authHeader() });
  }

export const taskService = { getAllTasks, addTask, deleteTask, updateTask, getAllTasksByUserId };
