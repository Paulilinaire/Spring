import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { taskService } from '../services/taskService'; // Assuming taskService is correctly implemented

const CreateTask = () => {
    const [task, setTask] = useState({
        title: '',
        desc: '',
        isCompleted: false
    });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setTask(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const { title, desc, isCompleted } = task;
            await taskService.addTask(title, desc, isCompleted);
            console.log("Task added successfully");
            navigate('/tasks');
        } catch (error) {
            console.error("Error adding task: ", error);
        }
    };

    return (
        <div className="container mt-5">
            <h2>Créer une nouvelle tâche</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="taskTitle" className="form-label">Titre</label>
                    <input 
                        type="text" 
                        className="form-control" 
                        id="taskTitle" 
                        name="title" 
                        value={task.title} 
                        onChange={handleChange} 
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="taskDesc" className="form-label">Description</label>
                    <input 
                        type="text" 
                        className="form-control" 
                        id="taskDesc" 
                        name="desc" 
                        value={task.desc} 
                        onChange={handleChange} 
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="taskCompleted" className="form-label">Complété</label>
                    <select 
                        className="form-select" 
                        id="taskCompleted" 
                        name="isCompleted" 
                        value={task.isCompleted} 
                        onChange={handleChange}
                    >
                        <option value={false}>to do</option>
                        <option value={true}>done</option>
                    </select>
                </div>
                <button type="submit" className="btn btn-primary">Créer</button>
            </form>
        </div>
    );
};

export default CreateTask;
