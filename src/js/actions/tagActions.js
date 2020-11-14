import Axios from "axios"
import { GET_TAG } from "./api"
import { FETCH_TAG } from "./types"


export const fetchTag = () => dispatch => {
  return Axios.get(GET_TAG)
    .then(tag => {
      dispatch({ type: FETCH_TAG, payload: tag.data })
      
    })
    
}