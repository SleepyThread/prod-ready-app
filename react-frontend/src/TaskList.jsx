import React, { useState, useEffect } from "react";

const TaskList = () => {
  
  const [ isLoading, setIsLoading] = useState(true);
  const [ fetchFailed, setFetchFailed] = useState(false);
  const [ taskList, setTaskList ] = useState([]);

  useEffect(() => {
    fetch('api/v1/list')
      .then(res => res.json())
      .then(response => {
        setTaskList(response);
        setIsLoading(false);
      })
      .catch(error => setFetchFailed(true));
  },[]);

  return (
    <div>
      <h1>Task List</h1>
      {fetchFailed && <p >Task List loading failed.</p>}
      {!fetchFailed && isLoading  && <p>Wait I am Loading Task List for you</p>}

      <br/>  
      <h3>List are : </h3>  
      <ul>
        {taskList.map((c) => <li key={c.id}>{c.taskInfo}</li>) }
      </ul>  
    </div>
  );
}

export default TaskList;
