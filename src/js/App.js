import 'bootstrap/dist/css/bootstrap.min.css'
import React from 'react'
import Notification from './components/popUp/Notification'
import SimpleTabs from './components/SimpleTabs'

const App = () => {
  return (
    <>
        <SimpleTabs />
        <Notification/>
    </>
  )
}

export default App
