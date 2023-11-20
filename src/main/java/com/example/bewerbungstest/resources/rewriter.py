from pyllamacpp.model import Model


def callback(text):
    print(text, end="")


summariser = Model(ggml_model='gpt4all-converted.bin', n_ctx=512)


# Define the callback function
def new_text_callback(text: str):
    print(text, end="")


input_1 = "We are going to implement a ::neural network::('technical term 1') with a ::regularized callback::('technical term 2') to determine whether or not we need " \
         "::anomaly detection::('technical term 3')."

input_2 = "We are going to implement a ::neural network::('technical term 1') with a ::regularized callback::('technical term 2') to determine whether or not we need something sepecial" \
         "for our Meeting at the secound of August 20.2.2023. When is the Appointment again?"

input_ = f'lets summarize the technical core ideas of following text in a bullet list::\"{input_1}\"::\n 1.)technical term 1:'

result = summariser.generate(prompt=input_, n_threads=8, new_text_callback=callback,n_predict=100)[len(input_)-20:]

input_ = f'briefly explained\n::\"{result}\"::\n 1.)explanation for technical term 1: '


result_1 = summariser.generate(prompt=input_, n_threads=8, new_text_callback=callback,n_predict=230)[len(input_)-36:]

input_ = f'::\"{result_1}\":: in a JSON Format:'

result = summariser.generate(prompt=input_, n_threads=8,verbose=False)[len(input_)]

print(result)


