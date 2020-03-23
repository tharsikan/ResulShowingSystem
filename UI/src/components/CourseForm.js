import React,{useState,useEffect} from 'react';
import axios from 'axios'
function CourseForm() {
  let [batchs, setBatchs] = useState([]);
  let [degrees, setDegrees] = useState([]);
  let [levels, setLevels] = useState([]);
  let [levelShow, setLevelShow] = useState(true);
  let [degreesShow, setDegreesShow] = useState(true);
  let [course, setCourse]  = useState({
      courseCode:'',
      courseTitle:'',
      batchId:'',
      degreeProgramId:'',
      levelId:''
  });
  // get batchs 
    useEffect(()=>{
        axios.get('http://localhost:8012/batch')
            .then(response=>{
                setBatchs(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
    },[])

  let selectBatch = (e) => {
    setCourse({...course, batchId: e.target.value})
    setDegreesShow(false)
    axios.get('http://localhost:8012/batch/'+e.target.value+'/degreeProgram')
            .then(response=>{
                setDegrees(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  let selectDegree = (e) => {
    setCourse({...course, degreeProgramId: e.target.value})
    setLevelShow(false)
    axios.get('http://localhost:8012/degreeProgram/'+e.target.value+'/level')
            .then(response=>{
                setLevels(response.data)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  let selectLevel = (e) => {
    setCourse({...course, levelId: e.target.value})
    console.log(course)
  }

  

//   let selectFile = (e) => {
//     var selectedFile = e.target.files[0];
//     let result = 'File name: ' + selectedFile.name;
//     result += '<br>File type: ' + selectedFile.type;
//     result += '<br>File size: ' + selectedFile.size;
//   }

//   let selectFiles = (e) => {
//     let selectedFiles = e.target.files;
//     let result = '';
//     for (var i = 0; i < selectedFiles.length; i++) {
//       result += '<br>File name: ' + selectedFiles[i].name;
//       result += '<br>File type: ' + selectedFiles[i].type;
//       result += '<br>File size: ' + selectedFiles[i].size;
//       result += '<br>--------------------------';
//     }
//   }

  let courseCodeHandil = (e) =>{
    setCourse({...course, courseCode: e.target.value})
  }
  let courseTitleHandil = (e) =>{
    setCourse({...course, courseTitle: e.target.value})
  }
  let submitHandil = (e) =>{
    e.preventDefault()
    console.log(course)
    axios.post('http://localhost:8012/course',course)
            .then(response=>{
                console.log(response)
                })
            .catch(error=>{
                    console.log(error)
                })
  }

  return (
    <form onSubmit={submitHandil}>
      <fieldset>
        Batch <select onChange={selectBatch}>
        <option disabled selected value> -- Batch -- </option>
            {
                batchs.map(batch=>(
                    <option value={batch.id}>{batch.batchId}</option>
                ))
            }
        </select>
        <br />
      </fieldset>
      <fieldset>
      Degree Program <select onChange={selectDegree} disabled={degreesShow}>
        <option disabled selected value> -- Degree Program -- </option>
            {
                degrees.map(degree=>(
                    <option value={degree.id}>{degree.degreeProgram}</option>
                ))
            }
        </select>
        <br />
      </fieldset>
      
      <fieldset>
      Level <select onChange={selectLevel} disabled={levelShow}>
        <option disabled selected value> -- Level -- </option>
            {
                levels.map(level=>(
                    <option value={level.id}>{level.level}</option>
                ))
            }
        </select>
        <br />
      </fieldset>
      <fieldset>
        <label>Course Code</label>
            <input type="text" value={course.courseCode} onChange={courseCodeHandil}></input>
      </fieldset>
      <fieldset>
            <label>Course Title</label>
            <input type="text" value={course.courseTitle} onChange={courseTitleHandil}></input>
      </fieldset>
      
      {/* <fieldset>
        <legend>Demo 3</legend>
        Photo <input type="file" onChange={selectFile} />
        <br />
        <span dangerouslySetInnerHTML={{ __html: result3 }}></span>
      </fieldset>

      <fieldset>
        <legend>Demo 4</legend>
        Photos <input type="file" onChange={selectFiles} multiple={true} />
        <br />
        <span dangerouslySetInnerHTML={{ __html: result4 }}></span>
      </fieldset> */}
        <button type="submit">Submit</button>
    </form>
  );
};
export default CourseForm
