//Material UI
import Snackbar from '@material-ui/core/Snackbar'
import { makeStyles } from '@material-ui/core/styles'
import MuiAlert from '@material-ui/lab/Alert'
import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { clearSnackbar } from '../../actions/notificationActions'

//Style functions
function Alert(props) {
  return <MuiAlert elevation={6} variant='filled' {...props} />
}

const useStyles = makeStyles(theme => ({
  root: {
    width: '100%',
    '& > * + *': {
      marginTop: theme.spacing(2),
    },
  },
}))

function Notification() {
  const classes = useStyles()

  const dispatch = useDispatch()

  const { snackbarMessage, snackbarStatus, snackbarOpen } = useSelector(
    state => state.notifications
  )

  function handleClose() {
    dispatch(clearSnackbar())
  }

  return (
    <div className={classes.root}>
      <Snackbar
        open={snackbarOpen}
        autoHideDuration={4000}
        onClose={handleClose}
      >
   
        <Alert onClose={handleClose} severity={snackbarStatus}>
          {snackbarMessage}
        </Alert>
      </Snackbar>
    </div>
  )
}

export default Notification
