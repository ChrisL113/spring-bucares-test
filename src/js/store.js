
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import rootReducer from './reducers';

const initialState = {};

const midddleware = [thunk];

const store = createStore(
  rootReducer,
  initialState,
  applyMiddleware(...midddleware)
);

export default store;