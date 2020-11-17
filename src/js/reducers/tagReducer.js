import { FETCH_TAG } from "../actions/types"

const initialState = {
  item: 'unknown',
}

export default function (state = initialState, action) {
  switch (action.type) {
    case FETCH_TAG:
      return {
        ...state,
        item: action.payload,
      }

    default:
      return state
  }
}
