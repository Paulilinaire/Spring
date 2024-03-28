import React, { useState } from 'react';

function UpdateTaskModal({ task, onSave, onCancel }) {
  const [title, setTitle] = useState(task?.title);
  const [desc, setDesc] = useState(task?.desc);
  const [isCompleted, setIsCompleted] = useState(task?.isCompleted);

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave({id: task.id, title, desc, isCompleted });
  };

  return (
    <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0,0,0,0.5)' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Update Task</h5>
            <button type="button" className="close" onClick={onCancel}>
              <span>&times;</span>
            </button>
          </div>
          <div className="modal-body">
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Tile</label>
                <input type="text" className="form-control" value={title} onChange={(e) => setTitle(e.target.value)} />
              </div>
              <div className="form-group">
                <label>Description</label>
                <input type="text" className="form-control" value={desc} onChange={(e) => setDesc(e.target.value)} />
              </div>
              <div className="form-group">
                <label>Status</label>
                <select className="form-control" value={isCompleted} onChange={(e) => setIsCompleted(e.target.value)}>
                    <option value={false}>to do</option>
                    <option value={true}>done</option>
                </select>
              </div>
              <button type="submit" className="btn btn-primary">Save changes</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UpdateTaskModal;
