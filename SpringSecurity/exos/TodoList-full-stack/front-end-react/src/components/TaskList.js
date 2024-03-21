import React, { useEffect, useState } from 'react';
import UpdateTaskModal from './UpdateTaskModal'; 
import { taskService } from '../services/taskService';

function TaskList() {
  const [tasks, setTasks] = useState([]); 
  const [error, setError] = useState('');

  useEffect(() => {
    taskService.getAllTasks() 
      .then(response => {
        console.log(response)
        setTasks(response.data); 
      })
      .catch(error => {
        setError('Erreur lors de la récupération des tâches.'); 
      });
  }, []);

  const loadTasks = () => {
    taskService.getAllTasks() 
      .then(response => {
        setTasks(response.data); 
      })
      .catch(error => {
        setError('Erreur lors de la récupération des tâches.'); 
      });
  };

  const [selectedTask, setSelectedTask] = useState(null); 

  const updateTask = (taskData) => {
    taskService.updateTask(taskData) 
      .then(() => {
        loadTasks(); 
        setSelectedTask(null);
      })
      .catch(error => {
        setError('Erreur lors de la mise à jour de la tâche.'); 
      });
  };

  const handleDelete = async (id) => {
    try {
      await taskService.deleteTask(id); 
      console.log('Task deleted successfully');
      const updatedTasks = tasks.filter(task => task.id !== id); 
      setTasks(updatedTasks); 
    } catch (error) {
      console.error('Error deleting task: ', error);
    }
  };

  return (
    <div className="container mt-5">
      <h2>Task List</h2> 
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table text-center">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Status</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task, index) => ( 
            <tr key={task.id}> 
              <th scope="row">{index + 1}</th>
              <td>{task.title}</td> 
              <td>{task.desc}</td> 
              <td>
                <button onClick={() => handleDelete(task.id)} className='btn btn-danger mr-2'>Supprimer</button>
                <button className='btn btn-warning' onClick={() => setSelectedTask(task)}>Update</button> 
              </td>
            </tr>
          ))}
          {selectedTask && (
            <UpdateTaskModal
              task={selectedTask} 
              onSave={updateTask}
              onCancel={() => setSelectedTask(null)} 
            />
          )}
        </tbody>
      </table>
    </div>
  );
}

export default TaskList;
